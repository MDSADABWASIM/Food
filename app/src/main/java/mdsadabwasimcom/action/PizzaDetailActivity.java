package mdsadabwasimcom.action;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.TextView;

public class PizzaDetailActivity extends Activity {
    private ShareActionProvider shareActionProvider;
    public static final String EXTRA_PIZZANO="pizzaNo";
    Drawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_detail);

        //Enable the UP button
       getActionBar().setHomeButtonEnabled(true);

        //display the details of pizza
        int pizzaNo = (int) getIntent().getExtras().get(EXTRA_PIZZANO);
        String pizzaName = Pizza.pizzas[pizzaNo].getName();
        TextView textView= (TextView) findViewById(R.id.pizza_text);
        textView.setText(pizzaName);
        int pizzaImage=Pizza.pizzas[pizzaNo].getImageResourceId();
        ImageView imageView= (ImageView) findViewById(R.id.pizza_image);

        //cause getDrawable is deprecated after Lollipop.
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            drawable= getResources().getDrawable(pizzaImage);
        } else {
            drawable= getResources().getDrawable(pizzaImage, null);
        }
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(pizzaName);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);

        //share the name of the pizza
        TextView textView= (TextView) findViewById(R.id.pizza_text);
        CharSequence pizzaNames=textView.getText();
        MenuItem menuItem=menu.findItem(R.id.action_share);
        shareActionProvider = (ShareActionProvider) menuItem.getActionProvider();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,pizzaNames);
        shareActionProvider.setShareIntent(intent);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_create_order:
                Intent intent = new Intent(this,OrderActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }
}
