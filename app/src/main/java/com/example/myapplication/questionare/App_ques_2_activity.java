package com.example.myapplication.questionare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class App_ques_2_activity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Model> list;
    List<Integer> itemlist;
    Button button;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_ques_2_activity);

        recyclerView = findViewById(R.id.rcv);
        button = findViewById(R.id.ques_button);
        constraintLayout = findViewById(R.id.app_ques2_layout);
        button.setEnabled(false);
        itemlist = new ArrayList<>();
        list = new ArrayList<>();

        list.add(new Model(R.drawable.namaha22_image1,"Better Sleep",0));
        list.add(new Model(R.drawable.namaha22_image2,"Reduce Stress",0));
        list.add(new Model(R.drawable.namaha22_image3,"Improve Focus",0));
        list.add(new Model(R.drawable.namaha22_image4,"Reduce Anxiety",0));
        list.add(new Model(R.drawable.namaha22_image5,"Lose Weight",0));
        list.add(new Model(R.drawable.namaha22_image6,"Remain Calm",0));

        Ques_2_Adapter adapter = new Ques_2_Adapter(this,list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        adapter.setOnItemClickListener(new Ques_2_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, MaterialCardView materialCardView) {
                button.setTextColor(getResources().getColor(R.color.rectangle_109_color));
                button.setBackgroundColor(getResources().getColor(R.color.black));
                button.setEnabled(true);
                if (materialCardView.getStrokeWidth() == 0){
                    materialCardView.setStrokeWidth(5);
                    if (!itemlist.contains(new Integer(pos))){
                        itemlist.add(pos);
                    }
                }else {
                    materialCardView.setStrokeWidth(0);
                    itemlist.remove(new Integer(pos));
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(itemlist);
                    if (itemlist.size() == 0){
                        Snackbar snackbar = Snackbar.make(constraintLayout,"Please select your choice...", Snackbar.LENGTH_SHORT);
                        snackbar.setTextColor(getResources().getColor(R.color.white));
                        snackbar.setBackgroundTint(getResources().getColor(R.color.black));
                        snackbar.show();
                    }else {
                        Intent i = new Intent(App_ques_2_activity.this, App_ques_3_activity.class);
                        startActivity(i);
                        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                    }
            }
        });

    }
}

//<LinearLayout
//            android:layout_width="match_parent"
//                    android:layout_height="0dp"
//                    android:layout_marginTop="30dp"
//                    android:orientation="vertical"
//                    app:layout_constraintEnd_toEndOf="parent"
//                    app:layout_constraintStart_toStartOf="parent"
//                    app:layout_constraintBottom_toTopOf="@+id/rectangle_132"
//                    app:layout_constraintTop_toBottomOf="@+id/what_brings_you_to__namaha_">
//
//<ScrollView
//                android:layout_width="match_parent"
//                        android:layout_height="wrap_content"
//                        android:scrollbarThumbVertical="@android:color/transparent">
//
//<LinearLayout
//                    android:layout_width="match_parent"
//                            android:layout_height="wrap_content"
//                            android:orientation="vertical">
//
//<androidx.constraintlayout.widget.ConstraintLayout
//        android:layout_width="match_parent"
//        android:layout_height="match_parent">
//
//<com.google.android.material.card.MaterialCardView
//        android:id="@+id/materialCardView2"
//        android:layout_width="0dp"
//        android:layout_height="168dp"
//        android:layout_marginStart="30dp"
//        android:transitionName="box1"
//        android:layout_marginLeft="30dp"
//        android:backgroundTint="@color/rectangle_129_color"
//        app:cardCornerRadius="9dp"
//        app:layout_constraintEnd_toStartOf="@+id/materialCardView"
//        app:layout_constraintStart_toStartOf="parent"
//        app:layout_constraintTop_toTopOf="parent"
//        tools:ignore="MissingConstraints">
//
//<androidx.constraintlayout.widget.ConstraintLayout
//        android:layout_width="match_parent"
//        android:layout_height="match_parent">
//
//<ImageView
//                                    android:id="@+id/namaha22_image2"
//                                            android:layout_width="90dp"
//                                            android:layout_height="90dp"
//                                            android:layout_marginTop="16dp"
//                                            android:contentDescription="istockphoto_920920498_612x612"
//                                            android:src="@drawable/namaha22_image1"
//                                            app:layout_constraintEnd_toEndOf="parent"
//                                            android:transitionName="image1"
//                                            app:layout_constraintHorizontal_bias="0.5"
//                                            app:layout_constraintStart_toStartOf="parent"
//                                            app:layout_constraintTop_toTopOf="parent" />
//
//<TextView
//                                    android:id="@+id/namaha22_text2"
//                                            android:layout_width="wrap_content"
//                                            android:layout_height="28dp"
//                                            android:layout_marginTop="18dp"
//                                            android:fontFamily="@font/circular"
//                                            android:text="Sleep Better"
//                                            android:textColor="#ffffff"
//                                            android:transitionName="text1"
//                                            android:textSize="18sp"
//                                            app:layout_constraintEnd_toEndOf="parent"
//                                            app:layout_constraintHorizontal_bias="0.5"
//                                            app:layout_constraintStart_toStartOf="parent"
//                                            app:layout_constraintTop_toBottomOf="@+id/namaha22_image2" />
//</androidx.constraintlayout.widget.ConstraintLayout>
//</com.google.android.material.card.MaterialCardView>
//
//<com.google.android.material.card.MaterialCardView
//        android:id="@+id/materialCardView"
//        android:layout_width="0dp"
//        android:layout_height="168dp"
//        android:layout_marginStart="47dp"
//        android:layout_marginLeft="47dp"
//        android:layout_marginEnd="30dp"
//        android:layout_marginRight="30dp"
//        android:backgroundTint="@color/rectangle_129_color"
//        app:cardCornerRadius="9dp"
//        app:layout_constraintEnd_toEndOf="parent"
//        app:layout_constraintStart_toEndOf="@+id/materialCardView2"
//        app:layout_constraintTop_toTopOf="parent"
//        tools:ignore="MissingConstraints">
//
//<androidx.constraintlayout.widget.ConstraintLayout
//        android:layout_width="match_parent"
//        android:layout_height="match_parent">
//
//<ImageView
//                                    android:id="@+id/namaha22_image1"
//                                            android:layout_width="90dp"
//                                            android:layout_height="90dp"
//                                            android:layout_marginTop="16dp"
//                                            android:contentDescription="istockphoto_920920498_612x612"
//                                            android:src="@drawable/namaha22_image2"
//                                            app:layout_constraintEnd_toEndOf="parent"
//                                            app:layout_constraintHorizontal_bias="0.5"
//                                            app:layout_constraintStart_toStartOf="parent"
//                                            app:layout_constraintTop_toTopOf="parent" />
//
//<TextView
//                                    android:id="@+id/namaha22_text1"
//                                            android:layout_width="wrap_content"
//                                            android:layout_height="28dp"
//                                            android:layout_marginTop="18dp"
//                                            android:fontFamily="@font/circular"
//                                            android:text="Sleep Better"
//                                            android:textColor="#ffffff"
//                                            android:textSize="18sp"
//                                            app:layout_constraintEnd_toEndOf="parent"
//                                            app:layout_constraintHorizontal_bias="0.509"
//                                            app:layout_constraintStart_toStartOf="parent"
//                                            app:layout_constraintTop_toBottomOf="@+id/namaha22_image1" />
//</androidx.constraintlayout.widget.ConstraintLayout>
//</com.google.android.material.card.MaterialCardView>
//</androidx.constraintlayout.widget.ConstraintLayout>
//
//<androidx.constraintlayout.widget.ConstraintLayout
//        android:layout_width="match_parent"
//        android:layout_height="match_parent"
//        android:layout_marginTop="25dp">
//
//<com.google.android.material.card.MaterialCardView
//        android:id="@+id/materialCardView4"
//        android:layout_width="0dp"
//        android:layout_height="168dp"
//        android:layout_marginStart="30dp"
//        android:layout_marginLeft="30dp"
//        android:backgroundTint="@color/rectangle_129_color"
//        app:cardCornerRadius="9dp"
//        app:layout_constraintEnd_toStartOf="@+id/materialCardView3"
//        app:layout_constraintStart_toStartOf="parent"
//        app:layout_constraintTop_toTopOf="parent"
//        tools:ignore="MissingConstraints">
//
//<androidx.constraintlayout.widget.ConstraintLayout
//        android:layout_width="match_parent"
//        android:layout_height="match_parent">
//
//<ImageView
//                                    android:id="@+id/namaha22_image4"
//                                            android:layout_width="90dp"
//                                            android:layout_height="90dp"
//                                            android:layout_marginTop="16dp"
//                                            android:contentDescription="istockphoto_920920498_612x612"
//                                            android:src="@drawable/namaha22_image3"
//                                            app:layout_constraintEnd_toEndOf="parent"
//                                            app:layout_constraintHorizontal_bias="0.5"
//                                            app:layout_constraintStart_toStartOf="parent"
//                                            app:layout_constraintTop_toTopOf="parent" />
//
//<TextView
//                                    android:layout_width="wrap_content"
//                                            android:layout_height="28dp"
//                                            android:layout_marginTop="18dp"
//                                            android:fontFamily="@font/circular"
//                                            android:text="Sleep Better"
//                                            android:textColor="#ffffff"
//                                            android:textSize="18sp"
//                                            app:layout_constraintEnd_toEndOf="parent"
//                                            app:layout_constraintHorizontal_bias="0.5"
//                                            app:layout_constraintStart_toStartOf="parent"
//                                            app:layout_constraintTop_toBottomOf="@+id/namaha22_image4" />
//</androidx.constraintlayout.widget.ConstraintLayout>
//</com.google.android.material.card.MaterialCardView>
//
//<com.google.android.material.card.MaterialCardView
//        android:id="@+id/materialCardView3"
//        android:layout_width="0dp"
//        android:layout_height="168dp"
//        android:layout_marginStart="47dp"
//        android:layout_marginLeft="47dp"
//        android:layout_marginEnd="30dp"
//        android:layout_marginRight="30dp"
//        android:backgroundTint="@color/rectangle_129_color"
//        app:cardCornerRadius="9dp"
//        app:layout_constraintEnd_toEndOf="parent"
//        app:layout_constraintStart_toEndOf="@+id/materialCardView4"
//        app:layout_constraintTop_toTopOf="parent"
//        tools:ignore="MissingConstraints">
//
//<androidx.constraintlayout.widget.ConstraintLayout
//        android:layout_width="match_parent"
//        android:layout_height="match_parent">
//
//<ImageView
//                                    android:id="@+id/namaha22_image3"
//                                            android:layout_width="90dp"
//                                            android:layout_height="90dp"
//                                            android:layout_marginTop="16dp"
//                                            android:contentDescription="istockphoto_920920498_612x612"
//                                            android:src="@drawable/namaha22_image4"
//                                            app:layout_constraintEnd_toEndOf="parent"
//                                            app:layout_constraintHorizontal_bias="0.5"
//                                            app:layout_constraintStart_toStartOf="parent"
//                                            app:layout_constraintTop_toTopOf="parent" />
//
//<TextView
//                                    android:layout_width="wrap_content"
//                                            android:layout_height="28dp"
//                                            android:layout_marginTop="18dp"
//                                            android:fontFamily="@font/circular"
//                                            android:text="Sleep Better"
//                                            android:textColor="#ffffff"
//                                            android:textSize="18sp"
//                                            app:layout_constraintEnd_toEndOf="parent"
//                                            app:layout_constraintHorizontal_bias="0.509"
//                                            app:layout_constraintStart_toStartOf="parent"
//                                            app:layout_constraintTop_toBottomOf="@+id/namaha22_image3" />
//</androidx.constraintlayout.widget.ConstraintLayout>
//</com.google.android.material.card.MaterialCardView>
//</androidx.constraintlayout.widget.ConstraintLayout>
//
//<androidx.constraintlayout.widget.ConstraintLayout
//        android:layout_width="match_parent"
//        android:layout_height="match_parent"
//        android:layout_marginTop="25dp">
//
//<com.google.android.material.card.MaterialCardView
//        android:id="@+id/materialCardView6"
//        android:layout_width="0dp"
//        android:layout_height="168dp"
//        android:layout_marginStart="30dp"
//        android:layout_marginLeft="30dp"
//        android:backgroundTint="@color/rectangle_129_color"
//        app:cardCornerRadius="9dp"
//        app:layout_constraintEnd_toStartOf="@+id/materialCardView5"
//        app:layout_constraintStart_toStartOf="parent"
//        app:layout_constraintTop_toTopOf="parent"
//        tools:ignore="MissingConstraints">
//
//<androidx.constraintlayout.widget.ConstraintLayout
//        android:layout_width="match_parent"
//        android:layout_height="match_parent">
//
//<ImageView
//                                    android:id="@+id/namaha22_image6"
//                                            android:layout_width="90dp"
//                                            android:layout_height="90dp"
//                                            android:layout_marginTop="16dp"
//                                            android:contentDescription="istockphoto_920920498_612x612"
//                                            android:src="@drawable/namaha22_image5"
//                                            app:layout_constraintEnd_toEndOf="parent"
//                                            app:layout_constraintHorizontal_bias="0.5"
//                                            app:layout_constraintStart_toStartOf="parent"
//                                            app:layout_constraintTop_toTopOf="parent" />
//
//<TextView
//                                    android:layout_width="wrap_content"
//                                            android:layout_height="28dp"
//                                            android:layout_marginTop="18dp"
//                                            android:fontFamily="@font/circular"
//                                            android:text="Sleep Better"
//                                            android:textColor="#ffffff"
//                                            android:textSize="18sp"
//                                            app:layout_constraintEnd_toEndOf="parent"
//                                            app:layout_constraintHorizontal_bias="0.5"
//                                            app:layout_constraintStart_toStartOf="parent"
//                                            app:layout_constraintTop_toBottomOf="@+id/namaha22_image6" />
//</androidx.constraintlayout.widget.ConstraintLayout>
//</com.google.android.material.card.MaterialCardView>
//
//<com.google.android.material.card.MaterialCardView
//        android:id="@+id/materialCardView5"
//        android:layout_width="0dp"
//        android:layout_height="168dp"
//        android:layout_marginStart="47dp"
//        android:layout_marginLeft="47dp"
//        android:layout_marginEnd="30dp"
//        android:layout_marginRight="30dp"
//        android:backgroundTint="@color/rectangle_129_color"
//        app:cardCornerRadius="9dp"
//        app:layout_constraintEnd_toEndOf="parent"
//        app:layout_constraintStart_toEndOf="@+id/materialCardView6"
//        app:layout_constraintTop_toTopOf="parent"
//        tools:ignore="MissingConstraints">
//
//<androidx.constraintlayout.widget.ConstraintLayout
//        android:layout_width="match_parent"
//        android:layout_height="match_parent">
//
//<ImageView
//                                    android:id="@+id/namaha22_image5"
//                                            android:layout_width="90dp"
//                                            android:layout_height="90dp"
//                                            android:layout_marginTop="16dp"
//                                            android:contentDescription="istockphoto_920920498_612x612"
//                                            android:src="@drawable/namaha22_image6"
//                                            app:layout_constraintEnd_toEndOf="parent"
//                                            app:layout_constraintHorizontal_bias="0.5"
//                                            app:layout_constraintStart_toStartOf="parent"
//                                            app:layout_constraintTop_toTopOf="parent" />
//
//<TextView
//                                    android:layout_width="wrap_content"
//                                            android:layout_height="28dp"
//                                            android:layout_marginTop="18dp"
//                                            android:fontFamily="@font/circular"
//                                            android:text="Sleep Better"
//                                            android:textColor="#ffffff"
//                                            android:textSize="18sp"
//                                            app:layout_constraintEnd_toEndOf="parent"
//                                            app:layout_constraintHorizontal_bias="0.509"
//                                            app:layout_constraintStart_toStartOf="parent"
//                                            app:layout_constraintTop_toBottomOf="@+id/namaha22_image5" />
//</androidx.constraintlayout.widget.ConstraintLayout>
//</com.google.android.material.card.MaterialCardView>
//</androidx.constraintlayout.widget.ConstraintLayout>
//
//<androidx.constraintlayout.widget.ConstraintLayout
//        android:layout_width="match_parent"
//        android:layout_height="match_parent"
//        android:layout_marginTop="25dp"
//        android:layout_marginBottom="25dp">
//
//<com.google.android.material.card.MaterialCardView
//        android:id="@+id/materialCardView8"
//        android:layout_width="0dp"
//        android:layout_height="168dp"
//        android:layout_marginStart="30dp"
//        android:layout_marginLeft="30dp"
//        android:backgroundTint="@color/rectangle_129_color"
//        app:cardCornerRadius="9dp"
//        app:layout_constraintEnd_toStartOf="@+id/materialCardView7"
//        app:layout_constraintStart_toStartOf="parent"
//        app:layout_constraintTop_toTopOf="parent"
//        tools:ignore="MissingConstraints">
//
//<androidx.constraintlayout.widget.ConstraintLayout
//        android:layout_width="match_parent"
//        android:layout_height="match_parent">
//
//<ImageView
//                                    android:id="@+id/namaha22_image8"
//                                            android:layout_width="90dp"
//                                            android:layout_height="90dp"
//                                            android:layout_marginTop="16dp"
//                                            android:contentDescription="istockphoto_920920498_612x612"
//                                            android:src="@drawable/namaha22_image7"
//                                            app:layout_constraintEnd_toEndOf="parent"
//                                            app:layout_constraintHorizontal_bias="0.5"
//                                            app:layout_constraintStart_toStartOf="parent"
//                                            app:layout_constraintTop_toTopOf="parent" />
//
//<TextView
//                                    android:id="@+id/sleep_better"
//                                            android:layout_width="wrap_content"
//                                            android:layout_height="28dp"
//                                            android:layout_marginTop="18dp"
//                                            android:fontFamily="@font/circular"
//                                            android:text="Sleep Better"
//                                            android:textColor="#ffffff"
//                                            android:textSize="18sp"
//                                            app:layout_constraintEnd_toEndOf="parent"
//                                            app:layout_constraintHorizontal_bias="0.5"
//                                            app:layout_constraintStart_toStartOf="parent"
//                                            app:layout_constraintTop_toBottomOf="@+id/namaha22_image8" />
//</androidx.constraintlayout.widget.ConstraintLayout>
//</com.google.android.material.card.MaterialCardView>
//
//<com.google.android.material.card.MaterialCardView
//        android:id="@+id/materialCardView7"
//        android:layout_width="0dp"
//        android:layout_height="168dp"
//        android:layout_marginStart="47dp"
//        android:layout_marginLeft="47dp"
//        android:layout_marginEnd="30dp"
//        android:layout_marginRight="30dp"
//        android:backgroundTint="@color/rectangle_129_color"
//        app:cardCornerRadius="9dp"
//        app:layout_constraintEnd_toEndOf="parent"
//        app:layout_constraintStart_toEndOf="@+id/materialCardView8"
//        app:layout_constraintTop_toTopOf="parent"
//        tools:ignore="MissingConstraints">
//
//<androidx.constraintlayout.widget.ConstraintLayout
//        android:layout_width="match_parent"
//        android:layout_height="match_parent">
//
//<ImageView
//                                    android:id="@+id/namaha22_image7"
//                                            android:layout_width="90dp"
//                                            android:layout_height="90dp"
//                                            android:layout_marginTop="16dp"
//                                            android:contentDescription="istockphoto_920920498_612x612"
//                                            android:src="@drawable/namaha22_image8"
//                                            app:layout_constraintEnd_toEndOf="parent"
//                                            app:layout_constraintHorizontal_bias="0.5"
//                                            app:layout_constraintStart_toStartOf="parent"
//                                            app:layout_constraintTop_toTopOf="parent" />
//
//<TextView
//                                    android:layout_width="wrap_content"
//                                            android:layout_height="28dp"
//                                            android:layout_marginTop="18dp"
//                                            android:fontFamily="@font/circular"
//                                            android:text="Sleep Better"
//                                            android:textColor="#ffffff"
//                                            android:textSize="18sp"
//                                            app:layout_constraintEnd_toEndOf="parent"
//                                            app:layout_constraintHorizontal_bias="0.509"
//                                            app:layout_constraintStart_toStartOf="parent"
//                                            app:layout_constraintTop_toBottomOf="@+id/namaha22_image7" />
//</androidx.constraintlayout.widget.ConstraintLayout>
//</com.google.android.material.card.MaterialCardView>
//</androidx.constraintlayout.widget.ConstraintLayout>
//</LinearLayout>
//</ScrollView>
//</LinearLayout>