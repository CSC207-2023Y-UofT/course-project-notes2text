package com.example.notes2text.file_sharing_use_case;

import java.util.*;
import java.io.File;
import android.net.Uri;
import androidx.core.content.FileProvider;


public class ThirdParShareUseCase implements ThirdParShareInputBoundary {
    private final ThirdPartyOutputBoundary outputBoundary;

    public ThirdParShareUseCase(ThirdPartyOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }
    @Override
    public ThirdPartyOutputModel create(FileSharingModel inputFiles) {
        ArrayList<File> files = inputFiles.getFile();
        ArrayList<Uri> fileUris = new ArrayList();
        ArrayList<String> filePaths = new ArrayList();
        for (File file : files) {
            filePaths.add(file.getAbsolutePath());
        }
        for (String filePath : filePaths) {
            File newFile = new File(filePath);
            Uri uri = FileProvider.getUriForFile(inputFiles.getContext(),
                    "com.example.notes2text.file_sharing_use_case.MyFileProvider", newFile);
            fileUris.add(uri);
        }
        ThirdPartyOutputModel outputUri = new ThirdPartyOutputModel(inputFiles.getContext(),
                fileUris);
        return outputBoundary.intentShare(outputUri);
    }
}
