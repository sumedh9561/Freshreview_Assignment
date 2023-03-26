package com.freshview.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.freshview.Repository.ItemRepository;
import com.freshview.Service.ItemService;
import com.freshview.exceptions.ItemNotFoundException;
import com.freshview.model.Items;

public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepo;

	@Override
	public Items addItem(Items item) {

		return itemRepo.save(item);

	}

	@Override
	public String removeItem(Long itemId) throws ItemNotFoundException {

		Items item = itemRepo.findById(itemId)
				.orElseThrow(() -> new ItemNotFoundException("Item Not Found With item id :" + itemId));

		return "Item Deleted Successfully";
	}

}
