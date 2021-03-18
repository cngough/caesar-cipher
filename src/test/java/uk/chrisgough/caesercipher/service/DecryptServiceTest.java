package uk.chrisgough.caesercipher.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uk.chrisgough.caesarcipher.exception.FailedToDecipherException;
import uk.chrisgough.caesarcipher.model.CipherRequest;
import uk.chrisgough.caesarcipher.model.CipherResponse;
import uk.chrisgough.caesarcipher.service.DecryptService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DecryptServiceTest {

    @Autowired
    private DecryptService decryptService;

    public String VALID_CIPHER_TEXT = "VJKUKUCUGETGVOGUUCIG";
    public List<String> VALID_CRIBS = Arrays.asList("THI", "MES");
    public String INVALID_CIPHER_TEXT = "INVALIDCIPHERTEXT";
    public List<String> INVALID_CRIBS = Arrays.asList("INVALID", "CRIBS");
    public String INVALID_EXCEPTION_RESPONSE = "Failed to find cribs [INVALID, CRIBS] for all rotations in given cipher [INVALIDCIPHERTEXT]";

    @Test
    public void givenSuccessfulCipherAndCribs_whenDecrypt_thenReturnDecodedCipher() {

        // Given
        CipherRequest cipherRequest = new CipherRequest(VALID_CIPHER_TEXT, VALID_CRIBS);

        // When
        CipherResponse cipherResponse = decryptService.decrypt(cipherRequest);

        // Then
        assertEquals("THISISASECRETMESSAGE", cipherResponse.getPlainText());
    }

    @Test
    public void givenUnsuccessfulCipherAndCribs_whenDecrypt_thenReturnError() {

        // Given
        CipherRequest cipherRequest = new CipherRequest(INVALID_CIPHER_TEXT, INVALID_CRIBS);

        // When
        FailedToDecipherException exception = Assertions.assertThrows(FailedToDecipherException.class, () -> {
            decryptService.decrypt(cipherRequest);
        });

        // Then
        assertEquals(INVALID_EXCEPTION_RESPONSE,exception.getMessage());
    }
}