package uk.chrisgough.caesarcipher.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import uk.chrisgough.caesarcipher.exception.FailedToDecipherException;
import uk.chrisgough.caesarcipher.model.CipherRequest;
import uk.chrisgough.caesarcipher.model.CipherResponse;

import java.text.MessageFormat;
import java.util.List;

@Service
public class DecryptServiceImpl implements DecryptService {

    private static final Logger LOG = LoggerFactory.getLogger(DecryptServiceImpl.class);

    @Override
    public CipherResponse decrypt(CipherRequest cipher) {

        LOG.debug("CipherRequest: {}", cipher);

        /* Brute force it, there's probably a more intelligent way */
        int shift = 1;

        /* Shift over the entire alphabet until we find text that contains the cribs */
        while (shift <= 26) {
            StringBuilder result = new StringBuilder();
            for (char character : cipher.getCipherText().toCharArray()) {
                int originalAlphabetPosition = character - 'A';
                int newAlphabetPosition = (originalAlphabetPosition + shift) % 26;
                char newCharacter = (char) ('A' + newAlphabetPosition);
                result.append(newCharacter);
            }

            LOG.debug("Shift: {}, Shift Text: {}", shift, result);

            /* Check whether or not the shifted string contains all the given cribs */
            if (checkStringContainsCribs(result, cipher.getCribs())) {
                return new CipherResponse(result.toString());
            }

            shift++;
        }

        throw new FailedToDecipherException(MessageFormat.format("Failed to find cribs {0} for all rotations in given cipher [{1}]", cipher.getCribs(), cipher.getCipherText()));
    }

    private boolean checkStringContainsCribs(StringBuilder sb, List<String> cribs) {

        for (String crib : cribs) {
            if (sb.indexOf(crib) == -1) {
                return false;
            }
        }
        return true;
    }
}
