# 쭌프로 라이브러리

- [image 관련 라이브러리](#image-관련-라이브러리)

# image 관련 라이브러리

BufferedImage handleThumbnail(byte[] image, int width, int height)

image 원본 이미지 파일, width 썸네일 생성 이미지 넓이, height 썸네일 생성 이미지 높이

# 인텔리제이 gradle jar 등록 방법

libs에 라이브러리 파일을 넣어두셨으면 build.gradle에 이 라이브러리를 사용하겠다고 선언하면 됩니다.
아래 코드는 build.gradle의 dependencies에 추가된 부분입니다. compile fileTree...는 libs 폴더의 모든 jar 파일을 라이브러리로 추가하겠다는 의미입니다.

~~~
dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    ....
}
~~~

만약 파일 1개만 추가하고 싶다면 아래 코드 처럼 Full path를 입력해주면 됩니다. 명령어는 fileTree에서 files로 변경해줘야 합니다.

~~~
dependencies {
    compile files('libs/gson-2.8.5.jar')
}
~~~