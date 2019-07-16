package com.mytaxi.app.utils.storage;

import com.mytaxi.app.models.User;

public interface Storage {

    User loadUser();

    void saveUser(User user);

    void resetUser();

}
