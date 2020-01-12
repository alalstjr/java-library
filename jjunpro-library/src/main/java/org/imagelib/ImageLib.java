package org.imagelib;

import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageLib {
    /**
     * 이미지 파일을 설정에 맞춰서 크기를 맞춰주는 메소드입니다.
     * 썸네일 이미지 생성에 사용됩니다.
     * (원본 image 정보, 썸네일 넓이값, 썸네일 높이값)
     */
    public static BufferedImage handleThumbnail(byte[] image, int width, int height) throws IOException {

        // 바이트 배열에서 BufferedImage 객체를 가져옵니다.
        InputStream   in            = new ByteArrayInputStream(image);
        BufferedImage originalImage = ImageIO.read(in);

        // 이미지 치수 얻기
        int originWidth  = originalImage.getWidth();
        int originHeight = originalImage.getHeight();

        // 늘어날 길이를 계산하여 패딩합니다.
        int newWidth  = originWidth;
        int newHeight = originHeight;

        if (newHeight > originHeight) {
            newWidth = ( originHeight * width ) / height;
            newHeight = originHeight;
        }

        // 늘려진 이미지의 중앙을 썸네일 비율로 크롭 합니다.
        BufferedImage cropImg = Scalr.crop(originalImage, ( originWidth - newWidth ) / 2, ( originHeight - newHeight ) / 2, newWidth, newHeight);
        // 리사이즈(썸네일 생성)
        BufferedImage result = Scalr.resize(cropImg, width, height);

        return result;
    }
}