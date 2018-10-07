package com.memebattle.megahack.main.fragment.request.presentation;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.memebattle.megahack.App;
import com.memebattle.megahack.main.fragment.request.presentation.recycler.RecyclerViewRequestsTaskAdapter;
import com.memebattle.megahack.main.fragment.request.data.model.RequestsTask;

import java.util.ArrayList;

@InjectViewState
public class RequestFragmentPresenter extends MvpPresenter <RequestFragmentView> implements RecyclerViewRequestsTaskAdapter.RecyclerCallback {

    public RequestFragmentPresenter(){
        /*App.apiRequestService.getTasks(new ApiRequestService.ProfileCallback() {
            @Override
            public void onSuccess(RequestTask requestTask) {
                ArrayList<RequestsTask> requestsTaskList = new ArrayList<>();
                requestsTaskList.add(new RequestsTask("",""));
                RecyclerViewRequestsTaskAdapter adapter = new RecyclerViewRequestsTaskAdapter(requestsTaskList);
                adapter.registerRecyclerCallback(RequestFragmentPresenter.this);
                getViewState().updateRecycler(adapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        }, getStoragePreference());
    */
        ArrayList<RequestsTask> requestsTaskList = new ArrayList<>();
        if (!App.deleteItem.equals("Сотовая связь"))requestsTaskList.add(new RequestsTask("Сотовая связь","Плохо ловит связь мегафона в деревне((", "Михаил"));
        if (!App.deleteItem.equals("Интернет"))requestsTaskList.add(new RequestsTask("Интернет","Мегафон, медленно!!!", "Александр"));
        if (!App.deleteItem.equals("Тарифы")) requestsTaskList.add(new RequestsTask("Тарифы","Дороговато на мегафоне", "Андрей"));
        if (!App.deleteItem.equals("Другое"))requestsTaskList.add(new RequestsTask("Другое","мегафон, интересное предложение", "Артём"));
        RecyclerViewRequestsTaskAdapter adapter = new RecyclerViewRequestsTaskAdapter(requestsTaskList);
        adapter.registerRecyclerCallback(this);
        getViewState().updateRecycler(adapter);
    }
    private String getStoragePreference(){
        return App.settingsService.getUserId();
    }

    @Override
    public void onItemClick(int requestId) {
        getViewState().openNote(requestId);
    }
}
