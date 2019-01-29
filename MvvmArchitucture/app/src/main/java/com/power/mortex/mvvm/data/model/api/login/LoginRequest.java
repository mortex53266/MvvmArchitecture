package com.power.mortex.mvvm.data.model.api.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginRequest {

    private LoginRequest() {

    }

    public static class ServerLoginRequest {

        @Expose
        @SerializedName("mobile_number")
        private String phoneNumber;
        @Expose
        @SerializedName("is_gifto")
        private Boolean isGifto;

        public ServerLoginRequest(String phoneNumber, Boolean isGifto) {
            this.phoneNumber = phoneNumber;
            this.isGifto = isGifto;
        }

        @Override
        public int hashCode() {
            int result = phoneNumber != null ? phoneNumber.hashCode() : 0;
            result = 31 * result + (isGifto != null ? isGifto.hashCode() : 0);
            return result;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || getClass() != object.getClass()) {
                return false;
            }

            ServerLoginRequest that = (ServerLoginRequest) object;

            if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) {
                return false;
            }
            return isGifto != null ? isGifto.equals(that.isGifto) : that.isGifto == null;
        }


        public String getPhoneNumber() {
            return phoneNumber;
        }

        public Boolean getGifto() {
            return isGifto;
        }
    }


}
