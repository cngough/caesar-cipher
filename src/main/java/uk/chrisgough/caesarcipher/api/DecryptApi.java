package uk.chrisgough.caesarcipher.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import uk.chrisgough.caesarcipher.model.CipherRequest;
import uk.chrisgough.caesarcipher.model.CipherResponse;

@RequestMapping(value = "/decrypt")
public interface DecryptApi {

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CipherResponse> decodeCipher(@RequestBody CipherRequest cipherRequest);

}
