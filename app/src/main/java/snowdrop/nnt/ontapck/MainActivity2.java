package snowdrop.nnt.ontapck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String a=getIntent().getStringExtra("ten");
        Toast.makeText(this, a, Toast.LENGTH_SHORT).show();
        TextView t=findViewById(R.id.textviewactivity2);
        t.setText(a);
    }
}