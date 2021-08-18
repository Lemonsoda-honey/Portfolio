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

		// Organic���`�F�b�N����Ă��邩����
		if (storeSearchForm.getIsOrganic()) {
			// �`�F�b�N����Ă���ꍇ
			searchCondition.setIsOrganic(true);
		}

		// Vegan���`�F�b�N����Ă��邩����
		if (storeSearchForm.getIsVegan()) {
			// �`�F�b�N����Ă���ꍇ
			searchCondition.setIsVegan(true);
		}
		// Caff���`�F�b�N����Ă��邩����
		if (storeSearchForm.getIsCaff()) {
			// �`�F�b�N����Ă���ꍇ
			searchCondition.setIsCaff(true);
		}

		// Restaurnat���`�F�b�N����Ă��邩����
		if (storeSearchForm.getIsRestaurnat()) {
			// �`�F�b�N����Ă���ꍇ
			searchCondition.setIsRestaurnat(true);
		}

		// Goods���`�F�b�N����Ă��邩����
		if (storeSearchForm.getIsGoods()) {
			// �`�F�b�N����Ă���ꍇ
			searchCondition.setIsGoods(true);
		}

		// �����ɊY�����邨�X�̏����擾
		List<Store> stores = storeService.findAll(Example.of(searchCondition));
		
		// Entity�N���X����\���p��Model�ɋl�ߑւ�
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
