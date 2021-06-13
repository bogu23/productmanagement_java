package com.sdaacademy.productmanagement.service;

import com.sdaacademy.productmanagement.entities.CartModel;
import com.sdaacademy.productmanagement.entities.ClientModel;
import com.sdaacademy.productmanagement.entities.OrderStatusModel;
import com.sdaacademy.productmanagement.entities.ProductModel;
import com.sdaacademy.productmanagement.repository.CartRepository;
import com.sdaacademy.productmanagement.repository.ClientRepository;
import com.sdaacademy.productmanagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;

    public void registerClient(ClientModel clientModel) {
        clientRepository.save(clientModel);
    }


    public void addToCart(long clientId, long productId) {
        Optional<ProductModel> productModelOptional = productRepository.findById(productId);
        if (!productModelOptional.isPresent()) {
            throw new RuntimeException("Product doesn't exist!");
        }
        ProductModel productModel = productModelOptional.get();
        Optional<ClientModel> clientModelOptional = clientRepository.findById(clientId);
        if (!clientModelOptional.isPresent()) {
            throw new RuntimeException("Client not exists!");
        }
        ClientModel clientModel = clientModelOptional.get();
        List<CartModel> cartModelList = clientModel.getCarts();

        CartModel cartFound = null;
        for (CartModel cart : cartModelList) {
            if (cart.getStatus().equals(OrderStatusModel.OPEN)) {
                cartFound = cart;
            }
        }
        if (cartFound == null) {
            cartFound = new CartModel();
            cartFound.setStatus(OrderStatusModel.OPEN);
            cartFound.setClientModel(clientModel);
        }
        cartFound.getProducts().add(productModel);
        //Calculam si totul

        cartRepository.save(cartFound);
    }

    public CartModel getCart(long clientId){
        Optional<ClientModel> clientModelOptional =  clientRepository.findById(clientId);
        if(!clientModelOptional.isPresent()){
            throw new RuntimeException("Client is not existing");
        }
        ClientModel clientModel = clientModelOptional.get();
        List<CartModel> cartModels = clientModel.getCarts();
        CartModel foundCart = null;
        for(CartModel cart :  cartModels){
            if(cart.getStatus().equals(OrderStatusModel.OPEN)){
                foundCart =  cart;
            }
        }
        return foundCart;
    }

}
