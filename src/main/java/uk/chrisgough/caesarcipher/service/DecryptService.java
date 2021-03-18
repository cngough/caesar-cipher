package uk.chrisgough.caesarcipher.service;

import uk.chrisgough.caesarcipher.model.CipherResponse;
import uk.chrisgough.caesarcipher.model.CipherRequest;

public interface DecryptService {

    CipherResponse decrypt(CipherRequest cipher);
}
