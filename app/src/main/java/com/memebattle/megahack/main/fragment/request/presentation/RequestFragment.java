package com.memebattle.megahack.main.fragment.request.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.memebattle.megahack.R;
import com.memebattle.megahack.main.activity.note.NoteActivity;
import com.memebattle.megahack.main.fragment.request.presentation.recycler.RecyclerViewRequestsTaskAdapter;

public class RequestFragment extends MvpAppCompatFragment implements RequestFragmentView {
    @InjectPresenter
    RequestFragmentPresenter presenter;
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_request, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        return view;
    }

    @Override
    public void updateRecycler(RecyclerViewRequestsTaskAdapter adapter) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(itemAnimator);
    }

    @Override
    public void openNote(int requestId) {
        Log.i("TAG","openNote " +requestId);
        Intent intent = new Intent(getActivity(),NoteActivity.class);
        if (requestId==0) {
            intent.putExtra("name", "Михаил");
            intent.putExtra("problem", "Сотовая связь");
            intent.putExtra("text", "Плохо ловит связь мегафона в деревне((");
        }
        if (requestId==1){
            intent.putExtra("name", "Александр");
            intent.putExtra("problem", "Интернет");
            intent.putExtra("text", "Мегафон, медленно!!!");
        }
        if (requestId==2){
            intent.putExtra("name", "Андрей");
            intent.putExtra("problem", "Тарифы");
            intent.putExtra("text", "Дороговато на мегафоне");
        }
        if (requestId==3){
            intent.putExtra("name", "Артём");
            intent.putExtra("problem", "Другое");
            intent.putExtra("text", "мегафон, интересное предложение");
        }
        startActivity(intent);
    }
}
