package com.gshoaib998.model;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.gshoaib998.model.databinding.ItemViewBinding;
import com.mikepenz.fastadapter.binding.AbstractBindingItem;

import java.util.List;

public class NoteItem extends AbstractBindingItem<ItemViewBinding> {
    Note note;
    NoteItem(Note note){
        this.note=note;
    }
    @NonNull
    @Override
    public ItemViewBinding createBinding(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        return ItemViewBinding.inflate(layoutInflater,viewGroup,false);
    }

    @Override
    public int getType() {
        return R.id.tv_title;
    }

    @Override
    public void bindView(@NonNull ItemViewBinding binding, @NonNull List<?> payloads) {
        super.bindView(binding, payloads);
        binding.tvTitle.setText(note.title);
    }

    @Override
    public void unbindView(@NonNull ItemViewBinding binding) {
        super.unbindView(binding);
        binding.tvTitle.setText(null);
    }
}
