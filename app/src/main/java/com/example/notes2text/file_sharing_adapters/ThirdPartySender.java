package com.example.notes2text.file_sharing_adapters;

import com.example.notes2text.file_sharing_use_case.ThirdPartyOutputModel;
import com.example.notes2text.file_sharing_use_case.ThirdPartyOutputBoundary;
import java.util.ArrayList;
import android.net.Uri;
import android.content.Intent;



public class ThirdPartySender implements ThirdPartyOutputBoundary {

    public ThirdPartyOutputModel intentShare(ThirdPartyOutputModel outputModel){
        ArrayList<Uri> fileUris = outputModel.getFileUris();
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND_MULTIPLE);
        sendIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, fileUris);

        /* May Need FILE MIME TYPE FOR TEXT FILE*/
        sendIntent.setType("text/*");
        outputModel.getContext().startActivity(Intent.createChooser(sendIntent, null));
        return outputModel;
    }
}
