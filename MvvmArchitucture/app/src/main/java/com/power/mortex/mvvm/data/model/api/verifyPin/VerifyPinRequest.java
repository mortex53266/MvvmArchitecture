package com.power.mortex.mvvm.data.model.api.verifyPin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VerifyPinRequest {

    private VerifyPinRequest() {

    }

    public static class VerifyPin {

        @Expose
        @SerializedName("mobile_number")
        private String mobile;
        @Expose
        @SerializedName("sms_code")
        private String pin;
        @Expose
        @SerializedName("notif_uuid")
        private String fcmToken;
        @Expose
        @SerializedName("is_gifto")
        private Boolean isGifto;

        public VerifyPin(String mobile, String pin, String fcmToken, Boolean isGifto) {
            this.mobile = mobile;
            this.pin = pin;
            this.fcmToken = fcmToken;
            this.isGifto = isGifto;
        }

        @Override
        public int hashCode() {
            int result = mobile != null ? mobile.hashCode() : 0;
            result = 31 * result + (isGifto != null ? isGifto.hashCode() : 0);
            return result;
        }


        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            VerifyPin that = (VerifyPin) obj;

            if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) {
                return false;
            }
            return isGifto != null ? isGifto.equals(that.isGifto) : that.isGifto == null;
        }


        public String getMobile() {
            return mobile;
        }

        public Boolean getIsGifto() {
            return isGifto;
        }

        public String getFcmToken() {
            return fcmToken;
        }

        public String getPin() {
            return pin;
        }
    }

}
