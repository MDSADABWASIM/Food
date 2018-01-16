package mdsadabwasimcom.action;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class PizzaMaterialFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        RecyclerView pizzaRecycler= (RecyclerView) inflater.inflate(R.layout.fragment_pizza_material,container,false);
        String[] pizzaNames = new String[Pizza.pizzas.length];
        for (int i=0;i<pizzaNames.length;i++){
            pizzaNames[i]=Pizza.pizzas[i].getName();
        }

        int[] pizzaImages= new int[Pizza.pizzas.length];
        for (int i=0;i<pizzaImages.length;i++){
            pizzaImages[i]=Pizza.pizzas[i].getImageResourceId();
        }
        CaptionedImagesAdapter captionedImagesAdapter=new CaptionedImagesAdapter(pizzaNames,pizzaImages);
        pizzaRecycler.setAdapter(captionedImagesAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        pizzaRecycler.setLayoutManager(linearLayoutManager);
        captionedImagesAdapter.setListener(new CaptionedImagesAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent= new Intent(getActivity(),PizzaDetailActivity.class);
                intent.putExtra(PizzaDetailActivity.EXTRA_PIZZANO,position);
                startActivity(intent);
            }
        });
        return pizzaRecycler;
    }

    public PizzaMaterialFragment() {
        // Required empty public constructor
    }


}
