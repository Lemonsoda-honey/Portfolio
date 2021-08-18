package com.example.map.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.form.StoreSearchForm;
import com.example.model.Store;
import com.example.service.StoreService;
import com.example.viewmodel.StoreViewModel;

@Controller

public class MaptopController {

	@Autowired
	private StoreService storeService;
	
	@GetMapping("maptop")
	public String getMaptop(Model model, @ModelAttribute StoreSearchForm storeSearchForm) {
		List<StoreViewModel> viewModels = new ArrayList<StoreViewModel>();
		model.addAttribute("storeViewModels", viewModels);
		return "map/maptop";

	}

	@PostMapping("maptop")
	public String search(Model model, @ModelAttribute StoreSearchForm storeSearchForm) {
		Store searchCondition = new Store();
		searchCondition.setEnabled(true);

		// Organicがチェックされているか判定
		if (storeSearchForm.getIsOrganic()) {
			// チェックされている場合
			searchCondition.setIsOrganic(true);
		}

		// Veganがチェックされているか判定
		if (storeSearchForm.getIsVegan()) {
			// チェックされている場合
			searchCondition.setIsVegan(true);
		}
		// Caffがチェックされているか判定
		if (storeSearchForm.getIsCaff()) {
			// チェックされている場合
			searchCondition.setIsCaff(true);
		}

		// Restaurnatがチェックされているか判定
		if (storeSearchForm.getIsRestaurnat()) {
			// チェックされている場合
			searchCondition.setIsRestaurnat(true);
		}

		// Goodsがチェックされているか判定
		if (storeSearchForm.getIsGoods()) {
			// チェックされている場合
			searchCondition.setIsGoods(true);
		}

		// 条件に該当するお店の情報を取得
		List<Store> stores = storeService.findAll(Example.of(searchCondition));
		
		// Entityクラスから表示用のModelに詰め替え
		List<StoreViewModel> viewModels = new ArrayList<StoreViewModel>();
		for (Store store : stores) {
			StoreViewModel viewModel = new StoreViewModel();
			viewModel.setId(store.getId());
			viewModel.setStoreName(store.getStoreName());
			viewModel.setAddress(store.getAddress());
			viewModels.add(viewModel);
		}

		model.addAttribute("storeViewModels", viewModels);
		return "map/maptop";

	}
}
