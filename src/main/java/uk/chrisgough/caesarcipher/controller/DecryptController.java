package uk.chrisgough.caesarcipher.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import uk.chrisgough.caesarcipher.model.CipherRequest;
import uk.chrisgough.caesarcipher.model.CipherResponse;
import uk.chrisgough.caesarcipher.service.DecryptService;
import uk.chrisgough.caesarcipher.api.DecryptApi;

@RestController
public class DecryptController implements DecryptApi {

    private final DecryptService decryptService;

    public DecryptController(final DecryptService decryptService) {

        this.decryptService = decryptService;
    }

    @Override
    public ResponseEntity<CipherResponse> decodeCipher(CipherRequest cipher) {

        CipherResponse response = this.decryptService.decrypt(cipher);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
