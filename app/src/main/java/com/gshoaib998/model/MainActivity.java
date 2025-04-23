package com.gshoaib998.model;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.gshoaib998.model.databinding.ActivityMainBinding;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    DataRepo dataRepo;
    FastAdapter<NoteItem> fastAdapter;
    ItemAdapter<NoteItem> itemAdapter;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dataRepo=new DataRepo();
        itemAdapter=new ItemAdapter<>();
        fastAdapter=FastAdapter.with(itemAdapter);
        binding.rv.setAdapter(fastAdapter);
        binding.rv.setLayoutManager(new LinearLayoutManager(this));
        binding.edTitle.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_DONE||event!=null&&event.getKeyCode()==KeyEvent.KEYCODE_ENTER|| Objects.requireNonNull(event).getAction()==KeyEvent.ACTION_DOWN){
                    String text=binding.edTitle.getText().toString();
                    dataRepo.addNote(new Note(text));
                    Toast.makeText(MainActivity.this, "Note added", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
        itemAdapter.add(getNoteItems());
    }
    public List<NoteItem> getNoteItems(){
        List<Note> notes=dataRepo.getAllNotes();
        List<NoteItem> noteItems=new ArrayList<>();
        for(Note note:notes){
            noteItems.add(new NoteItem(note));
        }
        return noteItems;
    }
}