package com.example.controllers;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.form.StoreForm;
import com.example.model.Store;
import com.example.service.StoreService;

@Controller
@RequestMapping("store")
public class StoreController {

	private final String STORE_TEMPLATE_PATH = "store/new";

	private final String INDEX_TEMPLATE_PATH = "store/index";

	private final String SHOW_TEMPLATE_PATH = "store/show";
	
	private final String EDIT_TEMPLATE_PATH = "store/edit";
	
	private final String STORE_INDEX_REDIRECT_URL = "redirect:/store/index";
	
	@Autowired
	private StoreService storeService;
	
	@GetMapping("new")
	public String newStore(@ModelAttribute StoreForm storeForm) {
		return STORE_TEMPLATE_PATH;
	}	
	
	@GetMapping("index")
	public String index(Model model) {
		List<Store> stores = storeService.findAll();
		model.addAttribute("stores", stores);

		return INDEX_TEMPLATE_PATH;
	}

	@GetMapping("show/{id}")
	public String show(@PathVariable Integer id, Model model) {

		Store storeDate = storeService.findOne(id);
		StoreForm store = setStoreForm(storeDate);
		boolean pictureFlag = true;
		if (storeDate.getPicture().length == 0) {
			pictureFlag = false;
		}
		model.addAttribute("store", store);
		model.addAttribute("pictureFlag", pictureFlag);

		return SHOW_TEMPLATE_PATH;
	}


	/**
	 * 画像表示.
	 * 
	 * @param id  ファイルID
	 * @param res HTTPレスポンス
	 */
	@GetMapping("/image/{id}")
	@ResponseBody
	public void showImage(@PathVariable int id, HttpServletResponse res) {
		// ファイル情報を取得
		Store storeDate = storeService.findOne(id);

		try (
				// ResponseのOutputStreamを代入
				OutputStream os = res.getOutputStream();) {
			// OutputStreamにファイルデータを書き出す
			os.write(storeDate.getPicture());
		} catch (IOException e) {
			// TODO 例外処理を実装
		}
	}
	@GetMapping("edit/{id}")
	public String edit(@PathVariable Integer id, Model model, @ModelAttribute StoreForm storeForm) {
		Store storeDate = storeService.findOne(id);
		StoreForm store = setStoreForm(storeDate);

		model.addAttribute("storeForm", store);

		return EDIT_TEMPLATE_PATH;
	}
	@PostMapping("create")
	public String create(@Valid @ModelAttribute StoreForm storeCreateForm, final BindingResult bindingResult) throws IOException {

		// 入力チェック
		if (bindingResult.hasErrors()) {
			// 入力チェックエラー時の処理
			return STORE_TEMPLATE_PATH;
		}

		Store store = storeCreateForm.toEntity();

		// ユーザー情報を保存
		storeService.save(store);

		return STORE_INDEX_REDIRECT_URL;
	}

	@PostMapping("update")
	public String update(@Valid @ModelAttribute StoreForm storeForm, final BindingResult bindingResult) {

		// 入力チェック
		if (bindingResult.hasErrors()) {
			// 入力チェックエラー時の処理
			return EDIT_TEMPLATE_PATH;
		}

		Store store = new Store();
		try {
			store = storeForm.toEntity();
		} catch (IOException e) {
			
		}

		// ユーザー情報を保存
		storeService.save(store);

		return STORE_INDEX_REDIRECT_URL;
	}
	private StoreForm setStoreForm(Store storeDate) {
		StoreForm store = new StoreForm();
		store.setId(storeDate.getId());
		store.setAddress(storeDate.getAddress());
		store.setEnabled(storeDate.isEnabled());
		
		if (storeDate.getFreespace() == null) {
			store.setFreespace("");
		} else {
			store.setFreespace(new String(storeDate.getFreespace()));
		}

		store.setStorename(storeDate.getStoreName());
		store.setUrl(storeDate.getUrl());
		store.setVegan(storeDate.getIsVegan());
		store.setOrganic(storeDate.getIsOrganic());
		store.setCaff(storeDate.getIsCaff());
		store.setRestaurnat(storeDate.getIsRestaurnat());
		store.setGoods(storeDate.getIsGoods());
		return store;
	}
}

