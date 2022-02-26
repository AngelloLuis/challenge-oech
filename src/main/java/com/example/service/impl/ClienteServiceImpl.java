package com.example.service.impl;

import com.example.commons.GenericServiceImpl;
import com.example.dto.ClienteDTO;
import com.example.model.Cliente;
import com.example.service.api.ClienteServiceAPI;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl extends GenericServiceImpl<Cliente, ClienteDTO> implements ClienteServiceAPI {

    @Autowired
    private Firestore firestore;

    @Override
    public CollectionReference getCollection() {
        return firestore.collection("clientes");
    }
}
