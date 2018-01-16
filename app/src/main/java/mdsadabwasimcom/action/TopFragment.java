package mdsadabwasimcom.action;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


public class TopFragment extends Fragment {



    public TopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
   RelativeLayout relativeLayout= (RelativeLayout) inflater.inflate(R.layout.fragment_top,container,false);
        RecyclerView recyclerView= (RecyclerView) relativeLayout.findViewById(R.id.pizza_recycle);
        String[] names=new String[Pizza.pizzas.length];
        int[] imageIds= new int[Pizza.pizzas.length];
        for (int i=0;i<names.length;i++){
            names[i]=Pizza.pizzas[i].getName();
            imageIds[i]=Pizza.pizzas[i].getImageResourceId();
        }
        CaptionedImagesAdapter adapter= new CaptionedImagesAdapter(names,imageIds);
        GridLayoutManager layoutManager= new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(),PizzaDetailActivity.class);
                intent.putExtra(PizzaDetailActivity.EXTRA_PIZZANO,position);
               startActivity(intent);
            }
        });
        // Inflate the layout for this fragment
        return relativeLayout;
    }

}
