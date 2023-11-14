package com.yusk.bookstore.rest;

import com.yusk.bookstore.dto.request.WishListPostRequestBody;
import com.yusk.bookstore.dto.request.WishListPutRequestBody;
import com.yusk.bookstore.mapper.WishListMapper;
import com.yusk.bookstore.model.Client;
import com.yusk.bookstore.model.WishList;
import com.yusk.bookstore.service.ClientService;
import com.yusk.bookstore.service.WishListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("wishlist")
//@CrossOrigin(origins = "http://localhost:8081")
public class
WishListRestController {
    @Autowired
    private WishListService wishListService;
    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<Iterable<WishList>> searchAll(){
        return ResponseEntity.ok(wishListService.searchAll());
    }
    @GetMapping("/{id}")
    @Operation(security = { @SecurityRequirement(name = "bearer-auth") })
    public ResponseEntity<WishList> searchById(@PathVariable Integer id){
        Optional<WishList> wishList = wishListService.searchById(id);
        if(wishList.isPresent()){
            return ResponseEntity.ok(wishList.get());
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping
    @Operation(security = { @SecurityRequirement(name = "bearer-auth") })
    public ResponseEntity<?> save(@RequestBody @Valid  WishListPostRequestBody wishListDTO) {
        WishList _wishList = WishListMapper.INSTANCE.toWishList(wishListDTO);
        Optional<Client> _client = clientService.searchById(wishListDTO.getClientId());
        if (_client.isPresent()){
            _wishList.setClient(_client.get());
            wishListService.save(_wishList);
            return ResponseEntity.status(HttpStatus.CREATED).body(_wishList);
        }
        return ResponseEntity.badRequest().body("Client not found");
    }

    @PutMapping("/{id}")
    @Operation(security = { @SecurityRequirement(name = "bearer-auth") })
    public ResponseEntity<WishList> changeName(@RequestParam Integer id, @RequestBody WishListPutRequestBody wishListDTO){
        Optional<WishList> _wishList = wishListService.searchById(id);
        if(_wishList.isEmpty())
            return ResponseEntity.notFound().build();
        WishListMapper.INSTANCE.updateWishList(wishListDTO, _wishList.get());
        wishListService.save(_wishList.get());
        return ResponseEntity.ok(_wishList.get());
    }

    @PutMapping("/{id}/{bookId}")
    @Operation(security = { @SecurityRequirement(name = "bearer-auth") })
    public ResponseEntity<?> addOrRemoveBook (@PathVariable Integer id, @PathVariable Integer bookId, @RequestParam(defaultValue = "add") String addOrRemove) {
        if(!addOrRemove.matches("add|remove"))
            return ResponseEntity.badRequest().body("Bad entry! Need to insert add or remove in path!");
        Optional<WishList> _wishList = wishListService.searchById(id);
        if(_wishList.isEmpty())
            return ResponseEntity.badRequest().body("Wish List id not found!");
        if(wishListService.addOrRemoveBook(_wishList.get(), bookId, addOrRemove))
            return ResponseEntity.ok().body(_wishList);
        return ResponseEntity.badRequest().body("Book id not found!");
    }

    @DeleteMapping("/{id}")
    @Operation(security = { @SecurityRequirement(name = "bearer-auth") })
    public ResponseEntity<String> delete (@RequestParam Integer id){
        Optional<WishList> wishList = wishListService.searchById(id);
        if(wishList.isPresent()) {
            wishListService.delete(id);
            return ResponseEntity.ok().body("success!");
        }
        return ResponseEntity.badRequest().body("WishList not found!");
    }
}
