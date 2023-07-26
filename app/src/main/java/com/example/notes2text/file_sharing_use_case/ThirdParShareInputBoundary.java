package com.example.notes2text.file_sharing_use_case;


public interface ThirdParShareInputBoundary {
    ThirdPartyOutputModel create(FileSharingModel inputFiles);
}
