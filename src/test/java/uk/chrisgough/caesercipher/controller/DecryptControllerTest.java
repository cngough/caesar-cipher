package uk.chrisgough.caesercipher.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import uk.chrisgough.caesarcipher.controller.DecryptController;
import uk.chrisgough.caesarcipher.model.CipherRequest;
import uk.chrisgough.caesarcipher.model.CipherResponse;
import uk.chrisgough.caesarcipher.service.DecryptService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DecryptControllerTest {

    @InjectMocks
    private DecryptController target;

    @Mock
    private DecryptService mockDecryptService;

    @Test
    public void givenValidCipherAndCribs_whenDecrypt_thenReturnDecodedCipher() {

        // Given
        CipherResponse cipherResponse = Mockito.mock(CipherResponse.class);
        when(mockDecryptService.decrypt(any())).thenReturn(cipherResponse);

        // When
        CipherRequest cipherRequest = Mockito.mock(CipherRequest.class);
        ResponseEntity<CipherResponse> response = target.decodeCipher(cipherRequest);

        // Then
        verify(mockDecryptService, Mockito.times(1)).decrypt(cipherRequest);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

}