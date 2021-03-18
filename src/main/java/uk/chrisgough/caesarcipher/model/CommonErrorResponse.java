package uk.chrisgough.caesarcipher.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class CommonErrorResponse {

    @JsonProperty("errormessage")
    private final String errorMessage;

    public CommonErrorResponse(String errorMessage) {

        this.errorMessage = errorMessage;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        CommonErrorResponse that = (CommonErrorResponse) o;

        return new EqualsBuilder().append(errorMessage, that.errorMessage).isEquals();
    }

    @Override
    public int hashCode() {

        return new HashCodeBuilder(17, 37).append(errorMessage).toHashCode();
    }

    @Override
    public String toString() {

        return new ToStringBuilder(this)
                .append("errorMessage", errorMessage)
                .toString();
    }
}
