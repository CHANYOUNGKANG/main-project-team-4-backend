package com.example.demo.category.dto;

import com.example.demo.item.entity.Item;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Getter @RequiredArgsConstructor
public class ItemInCategoryResponseDto {
    @Schema(description = "상품 id", example = "1")
    private Long id;
    @Schema(description = "상품 이름", example = "나이키 반팔티")
    private String name;
    @Schema(description = "상품 가격", example = "10000")
    private Integer price;
    @Schema(description = "상품 이미지", example = "https://images.kolonmall.com/Prod_Img/10003414/2022/LM1/K1681264588128081NO01_LM1.jpg")
    private String imageUrl;

    public ItemInCategoryResponseDto(Item entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.price = entity.getPrice();
        this.imageUrl = Optional.of(entity)
                .map(Item::getMain_image)
                .map(Object::toString)
                .orElse(null);
    }
}
