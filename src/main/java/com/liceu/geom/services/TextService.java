package com.liceu.geom.services;

import com.liceu.geom.DAO.MessageDAO;
import com.liceu.geom.DAO.MessageDAOImpl;
import com.liceu.geom.model.Message;

import java.util.Date;
import java.util.List;

public class TextService {
    MessageDAO messageDAO = new MessageDAOImpl();
    public void newText(String text){
        Date d= new Date();
        Message m= new Message(text,d);
        messageDAO.save(m);
    }

    public List<Message> getAllMessages() {
        return messageDAO.getAllMessages();
    }
}
