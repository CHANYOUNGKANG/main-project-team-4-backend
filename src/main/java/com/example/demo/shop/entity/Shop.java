package com.example.demo.shop.entity;

import com.example.demo.follow.entity.Follow;
import com.example.demo.item.entity.Item;
import com.example.demo.member.dto.SignupRequestDto;
import com.example.demo.member.entity.Member;
import com.example.demo.review.entity.Review;
import com.example.demo.shop.dto.ShopRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "shop")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String shopName;
    @Column(name = "intro")
    private String shopIntro;
    @Column(name = "star_avg")
    private Double star;

    @OneToMany(mappedBy = "shop", orphanRemoval = true)
    private List<Item> itemList = new ArrayList<>();

    @OneToMany(mappedBy = "shop", orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private Member member;

    @OneToMany(mappedBy = "shop")
    private List<Follow> follows = new ArrayList<>();

    public Shop(SignupRequestDto requestDto, Member member){
        this.shopName = requestDto.getNickname();
        this.member = member;
    }

    public Shop(ShopRequestDto requestDto, Member member){
        this.shopName = requestDto.getShopName();
        this.member = member;
    }

    public Shop(Member member){
        this.shopName = member.getNickname();
        this.member = member;
    }

    public void update(ShopRequestDto requestDto){
        this.shopIntro = requestDto.getShopIntro();
    }
}
