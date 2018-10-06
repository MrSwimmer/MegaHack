package com.memebattle.megahack.main.fragment.profile.presentation;

import com.arellomobile.mvp.MvpView;
import com.memebattle.megahack.main.fragment.profile.data.model.Profile;

public interface ProfileFragmentView extends MvpView {

    void setProfile(Profile profile);

}
