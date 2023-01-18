package com.example.myapplication;

import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.example.myapplication.adapter.NewReleaseRecyclerAdapter;
import com.example.myapplication.model.NewRelease;

public class MainActivity  extends AppCompatActivity {

    private NewReleaseRecyclerAdapter newReleaseRecyclerAdapter;
private List<NewRelease> newReleaseList;
private SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    searchView=(SearchView)findViewById(R.id.search1);
    searchView.clearFocus();
    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String s) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String s) {
            filterList(s);
            return true;

        }
    });
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView1);
    recyclerView.setHasFixedSize(true);

    newReleaseList=new ArrayList<>();

    NewRelease oiseau1=new NewRelease("حمام", R.drawable.hm);
    newReleaseList.add(oiseau1);
    NewRelease oiseau2=new NewRelease("دوري", R.drawable.dr);
    newReleaseList.add(oiseau2);
    NewRelease oiseau3=new NewRelease("العقعق",R.drawable.e9);
    newReleaseList.add(oiseau3);



    newReleaseRecyclerAdapter=new NewReleaseRecyclerAdapter(this,newReleaseList);
    recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    recyclerView.setAdapter(newReleaseRecyclerAdapter);
    newReleaseRecyclerAdapter.notifyDataSetChanged();
}

    private void filterList(String s) {
    List<NewRelease>filteredList=new ArrayList<>();
    for(NewRelease item:newReleaseList){
        if(item.getName().toLowerCase().contains(s.toLowerCase())){
            filteredList.add(item);
        }
    }
    if(filteredList.isEmpty()){
        Toast.makeText(this,"No results",Toast.LENGTH_SHORT).show();
        newReleaseRecyclerAdapter.setFilteredList(filteredList);
    }else{
       newReleaseRecyclerAdapter.setFilteredList(filteredList);
    }

}

}
