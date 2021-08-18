package com.example.user.controllers;

import java.util.List;

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

import com.example.user.form.sub.UserCreateForm;
import com.example.user.form.sub.UserUpdateForm;
import com.example.user.model.User;
import com.example.user.service.UserService;

/**
 * ユーザーマスタ画面のControllerクラス. クラスで@RequestMappingを利用すると、
 * リクエストURLが「クラスの@RequestMappingで指定したパス + メソッドで指定したパス」になります。
 */
@Controller
@RequestMapping("/user")
public class UserMasterController {

	/**
	 * UserEntityクラスを操作するServiceクラス.
	 */
	@Autowired
	private UserService userService;

	/**
	 * Redirect用一覧画面パス.
	 */
	private final String REDIRECT_INDEX_URL = "redirect:/user/index";

	/**
	 * 一覧画面のTemplateHTMLのパス.
	 */
	private final String INDEX_TEMPLATE_PATH = "user/index";

	/**
	 * 新規登録画面のTemplateHTMLのパス.
	 */
	private final String NEW_TEMPLATE_PATH = "user/new";

	/**
	 * 編集画面のTemplateHTMLのパス.
	 */
	private final String EDIT_TEMPLATE_PATH = "user/edit";

	/**
	 * 詳細画面のTemplateHTMLのパス.
	 */
	private final String SHOW_TEMPLATE_PATH = "user/show";

	/**
	 * ユーザーマスタ一覧画面表示.
	 *
	 * @param model Modelクラス
	 * @return HOME画面のテンプレートパス
	 */
	@RequestMapping("index")
	public String index(Model model) {
		List<User> users = userService.findAll();
		model.addAttribute("users", users);

		return INDEX_TEMPLATE_PATH;
	}

	/**
	 * ユーザー新規登録画面表示.
	 *
	 * @param userCreateForm ユーザー新規登録Formクラス
	 * @return ユーザー新規登録画面のテンプレートパス
	 */
	@GetMapping("new")
	public String newUser(@ModelAttribute UserCreateForm userCreateForm) {
		return NEW_TEMPLATE_PATH;
	}

	/**
	 * ユーザー編集画面表示.
	 *
	 * @param username ユーザー名
	 * @param model    Modelクラス
	 * @return ユーザー編集画面のテンプレートパス
	 */
	@GetMapping("edit/{username}")
	public String edit(@PathVariable String username, Model model) {
		User user = userService.findOne(username);
		model.addAttribute("userUpdateForm", new UserUpdateForm(user));
		return EDIT_TEMPLATE_PATH;
	}

	/**
	 * ユーザー詳細画面表示.
	 *
	 * @param username ユーザー名
	 * @param model    Modelクラス
	 * @return ユーザー詳細画面のテンプレートパス
	 */
	@GetMapping("show/{username}")
	public String show(@PathVariable String username, Model model) {
		// ユーザー情報を取得
		User user = userService.findOne(username);
		model.addAttribute("user", user);

		return SHOW_TEMPLATE_PATH;
	}

	/**
	 * ユーザーの新規登録処理.
	 *
	 * @param userCreateForm 新規登録画面の入力情報
	 * @param bindingResult  入力チェック結果
	 * @return 遷移先パス(エラーの場合、新規登録画面のテンプレートパス。成功の場合、一覧画面のテンプレートパス)
	 */
	@PostMapping("create")
	public String create(@Valid @ModelAttribute UserCreateForm userCreateForm, final BindingResult bindingResult) {

		// 入力チェック
		if (bindingResult.hasErrors()) {
			// 入力チェックエラー時の処理
			return NEW_TEMPLATE_PATH;
		}

		User user = userCreateForm.toEntity();

		// ユーザー情報を保存
		userService.save(user);

		return REDIRECT_INDEX_URL;
	}

	/**
	 * ユーザーの更新処理.
	 *
	 * @param userUpdateForm 編集画面の入力情報
	 * @param bindingResult  入力チェック結果
	 * @return 遷移先パス(エラーの場合、編集画面のテンプレートパス。成功の場合、一覧画面のテンプレートパス)
	 */
	@PostMapping("update")
	public String update(@Valid @ModelAttribute UserUpdateForm userUpdateForm, final BindingResult bindingResult) {

		// 入力チェック
		if (bindingResult.hasErrors()) {
			// 入力チェックエラー時の処理
			return EDIT_TEMPLATE_PATH;
		}

		User user = userUpdateForm.toEntity();

		// ユーザー情報を保存
		userService.save(user);

		return REDIRECT_INDEX_URL;
	}

}
