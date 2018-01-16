package mdsadabwasimcom.action;





import android.graphics.drawable.Drawable;

import android.os.Build;
import android.view.View;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;




public class CaptionedImagesAdapter extends RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder> {

private String[] captions;
    private int[] imageIds;
    private Listener listener;

    public  interface Listener{
         void onClick(int position);
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        public ViewHolder(CardView view) {
            super(view);
            cardView =view;
        }
    }
    public CaptionedImagesAdapter(String[] captions,int[] imageIds){
        this.captions=captions;
        this.imageIds=imageIds;
    }
    public void setListener(Listener listener){
        this.listener=listener;
    }

    @Override
    public CaptionedImagesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                int viewType) {
     CardView cv= (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_captioned_image, parent, false);


        return new ViewHolder(cv);
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder,  int position) {
      Drawable drawable;
        CardView cardView=holder.cardView;
        ImageView imageView= (ImageView) cardView.findViewById(R.id.info_image);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            drawable= cardView.getResources().getDrawable(imageIds[position]);
        } else {
           drawable= cardView.getResources().getDrawable(imageIds[position], null);
        }
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(captions[position]);
        TextView textView= (TextView) cardView.findViewById(R.id.info_text);
        textView.setText(captions[position]);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener!=null){
                    listener.onClick(holder.getAdapterPosition());
                }
            }
        });

    }



    @Override
    public int getItemCount() {

        return captions.length;
    }
}

