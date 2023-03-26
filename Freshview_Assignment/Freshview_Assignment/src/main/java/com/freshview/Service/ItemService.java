package com.freshview.Service;

import org.springframework.stereotype.Service;

import com.freshview.exceptions.ItemNotFoundException;
import com.freshview.model.Items;
@Service
public interface ItemService {

	Items addItem(Items item);

	String removeItem(Long itemId) throws ItemNotFoundException;

}
