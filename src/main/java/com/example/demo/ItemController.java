package com.example.demo;


import com.example.demo.dto.ItemDto;
import com.example.demo.dto.ItemFormDto;
import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;
import com.example.demo.service.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;
    private final ItemService itemService;
//    private final FileStore fileStore;

    @GetMapping({"", "/{page}"})
    public String read(Model model, @PathVariable("page") Optional<Integer> page) {
        List<ItemFormDto> items = itemRepository.findAllDto();
        model.addAttribute("items", items);
        return "item/list";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable Long itemId, Model model) {
        Item findItem = itemRepository.findById(itemId);
        model.addAttribute(findItem);
        return "item/item";
    }


    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("itemFormDto", new ItemFormDto());
        return "item/addForm";
    }

    @PostMapping("/create")
    public String add(@Valid ItemFormDto itemFormDto, BindingResult bindingResult,
                      Model model, @RequestParam("itemImgFile") List<MultipartFile> itemImgFileList) {

        if (bindingResult.hasErrors()) {
            return "item/addForm";
        }

        if (itemImgFileList.get(0).isEmpty() && itemFormDto.getId() == null) {
            model.addAttribute("errorMessage", "첫번째 상품 이미지는 필수 입력 값이빈다.");
            return "item/addForm";
        }
        try {
            itemService.saveItem(itemFormDto, itemImgFileList);
        } catch (Exception e) {
            model.addAttribute("errorMessage", "상품 등록 중 에러가 발생했습니다");
            return "item/addForm";
        }
        return "redirect:/";
    }

    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        Item findItem = itemRepository.findById(itemId);
        model.addAttribute("item", findItem);
        return "item/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable Long itemId, @ModelAttribute Item item) {
        itemRepository.update(itemId, item);
        return "redirect:/{itemId}";
    }

}
