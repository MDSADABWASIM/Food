package mdsadabwasimcom.action;

public class Pizza {
    public String name;
    public int imageResourceId;


    public static final Pizza[] pizzas ={
            new Pizza("veg",R.drawable.pizza1),
            new Pizza( "Non-veg",R.drawable.pizza2)
    };

    public Pizza(String name,int imageResourceId){
        this.name=name;
        this.imageResourceId=imageResourceId;
    }
    public String getName(){
        return name;
    }

    public int getImageResourceId(){
        return imageResourceId;
    }
}
