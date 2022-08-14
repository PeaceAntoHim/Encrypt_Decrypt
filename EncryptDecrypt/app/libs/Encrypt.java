package com.example.encryptdecrypt;

import android.util.Base64;
import java.nio.charset.Charset;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(
        mv = {1, 6, 0},
        k = 1,
        d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J/\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\tJ/\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\f¨\u0006\r"},
        d2 = {"Lcom/example/encryptdecrypt/EncryptDecrypt;", "", "()V", "decrypt", "", "dataCipher", "key", "iv", "algorithms", "decrypt$app_debug", "encrypt", "data", "encrypt$app_debug", "app_debug"}
)
public final class EncryptDecrypt {
    @NotNull
    public static final EncryptDecrypt INSTANCE;

    @NotNull
    public final String encrypt$app_debug(@NotNull String data, @NotNull String key, @NotNull String iv, @NotNull String algorithms) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(iv, "iv");
        Intrinsics.checkNotNullParameter(algorithms, "algorithms");

        try {
            long currentTimestamp = System.currentTimeMillis();
            long seconds = currentTimestamp / (long)1000 % (long)60;
            String var9 = "This time to see encrypt: " + seconds + " seconds";
            System.out.println(var9);
            Charset var11 = Charsets.UTF_8;
            byte[] var10002 = key.getBytes(var11);
            Intrinsics.checkNotNullExpressionValue(var10002, "this as java.lang.String).getBytes(charset)");
            SecretKeySpec secretKeySpec = new SecretKeySpec(var10002, "AES");
            Charset var12 = Charsets.UTF_8;
            var10002 = iv.getBytes(var12);
            Intrinsics.checkNotNullExpressionValue(var10002, "this as java.lang.String).getBytes(charset)");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(var10002);
            Cipher cipher = Cipher.getInstance(algorithms);
            cipher.init(1, (Key)secretKeySpec, (AlgorithmParameterSpec)ivParameterSpec);
            Charset var14 = Charsets.UTF_8;
            byte[] var10001 = data.getBytes(var14);
            Intrinsics.checkNotNullExpressionValue(var10001, "this as java.lang.String).getBytes(charset)");
            byte[] cipherText = cipher.doFinal(var10001);
            String var10000 = Base64.encodeToString(cipherText, 0);
            Intrinsics.checkNotNullExpressionValue(var10000, "Base64.encodeToString(cipherText, Base64.DEFAULT)");
            return var10000;
        } catch (Exception var15) {
            String var6 = "Start err in Encrypt Function";
            System.out.println(var6);
            var15.printStackTrace();
            var6 = "End err Encrypt Function";
            System.out.println(var6);
            return "something wrong";
        }
    }

    // $FF: synthetic method
    public static String encrypt$app_debug$default(EncryptDecrypt var0, String var1, String var2, String var3, String var4, int var5, Object var6) {
        if ((var5 & 8) != 0) {
            var4 = "AES/CBC/PKCS5Padding";
        }

        return var0.encrypt$app_debug(var1, var2, var3, var4);
    }

    @NotNull
    public final String decrypt$app_debug(@NotNull String dataCipher, @NotNull String key, @NotNull String iv, @NotNull String algorithms) {
        Intrinsics.checkNotNullParameter(dataCipher, "dataCipher");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(iv, "iv");
        Intrinsics.checkNotNullParameter(algorithms, "algorithms");

        try {
            long currentTimestamp = System.currentTimeMillis();
            long seconds = currentTimestamp / (long)1000 % (long)60;
            String var9 = "This time to see decrypt: " + seconds + " seconds";
            System.out.println(var9);
            Charset var11 = Charsets.UTF_8;
            byte[] var10002 = key.getBytes(var11);
            Intrinsics.checkNotNullExpressionValue(var10002, "this as java.lang.String).getBytes(charset)");
            SecretKeySpec secretKeySpec = new SecretKeySpec(var10002, "AES");
            Charset var12 = Charsets.UTF_8;
            var10002 = iv.getBytes(var12);
            Intrinsics.checkNotNullExpressionValue(var10002, "this as java.lang.String).getBytes(charset)");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(var10002);
            Cipher cipher = Cipher.getInstance(algorithms);
            cipher.init(2, (Key)secretKeySpec, (AlgorithmParameterSpec)ivParameterSpec);
            String var10000;
            byte[] bytes;
            if (StringsKt.contains$default((CharSequence)dataCipher, (CharSequence)"=", false, 2, (Object)null)) {
                bytes = cipher.doFinal(Base64.decode(dataCipher, 0));
                Intrinsics.checkNotNullExpressionValue(bytes, "plainText");
                var10000 = new String(bytes, Charsets.UTF_8);
            } else {
                Iterable $this$map$iv = (Iterable)StringsKt.chunked((CharSequence)dataCipher, 2);
                int $i$f$map = false;
                Collection destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10)));
                int $i$f$mapTo = false;
                Iterator var18 = $this$map$iv.iterator();

                while(var18.hasNext()) {
                    Object item$iv$iv = var18.next();
                    String it = (String)item$iv$iv;
                    int var21 = false;
                    byte var23 = 16;
                    Byte var25 = (byte)Integer.parseInt(it, CharsKt.checkRadix(var23));
                    destination$iv$iv.add(var25);
                }

                bytes = CollectionsKt.toByteArray((Collection)((List)destination$iv$iv));
                String encodedHexB64 = Base64.encodeToString(bytes, 0);
                byte[] plainText = cipher.doFinal(Base64.decode(encodedHexB64, 0));
                Intrinsics.checkNotNullExpressionValue(plainText, "plainText");
                var10000 = new String(plainText, Charsets.UTF_8);
            }

            return var10000;
        } catch (Exception var26) {
            String var6 = "Start err Decrypt Function";
            System.out.println(var6);
            var26.printStackTrace();
            var6 = "End err Decrypt Function";
            System.out.println(var6);
            return "something wrong";
        }
    }

    // $FF: synthetic method
    public static String decrypt$app_debug$default(EncryptDecrypt var0, String var1, String var2, String var3, String var4, int var5, Object var6) {
        if ((var5 & 8) != 0) {
            var4 = "AES/CBC/PKCS5Padding";
        }

        return var0.decrypt$app_debug(var1, var2, var3, var4);
    }

    private EncryptDecrypt() {
    }

    static {
        EncryptDecrypt var0 = new EncryptDecrypt();
        INSTANCE = var0;
        String var1 = "Start EncryptDecrypt with singleton";
        System.out.println(var1);
    }
}
