package com.liceu.geom.DAO;

import com.liceu.geom.model.Message;

import java.util.List;

public interface MessageDAO {
    void save (Message m);

    List<Message> getAllMessages();
}
