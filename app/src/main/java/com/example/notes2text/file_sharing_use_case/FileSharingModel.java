package com.example.notes2text.file_sharing_use_case;

import java.util.ArrayList;
import java.io.File;
import android.content.Context;


public class FileSharingModel {
    private final ArrayList<File> files;
    private final Context context;

    public FileSharingModel(Context context, ArrayList<File> shareFile) {
        this.files = shareFile;
        this.context = context;
    }

    public ArrayList<File> getFile() {
        return files;
    }

    public Context getContext() {
        return context;
    }
}