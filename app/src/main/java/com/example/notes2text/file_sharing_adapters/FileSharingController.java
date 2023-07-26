package com.example.notes2text.file_sharing_adapters;

import com.example.notes2text.file_sharing_use_case.ThirdParShareInputBoundary;
import com.example.notes2text.file_sharing_use_case.ThirdPartyOutputModel;
import com.example.notes2text.file_sharing_use_case.FileSharingModel;
import java.util.ArrayList;
import android.content.Context;
import java.io.File;


public class FileSharingController {
    private final ThirdParShareInputBoundary inputBoundary;

    public FileSharingController(ThirdParShareInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public ThirdPartyOutputModel create(Context context, ArrayList<File> files) {
        FileSharingModel inputFiles = new FileSharingModel(context, files);
        return inputBoundary.create(inputFiles);
    }
}
