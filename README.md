# [Open Api을 이용하여 클론 어플 제작]
***
#### Tech Stack
* Kakao Login Api, Glide, Retrofit2, themoviedb Movie Open Api, 

***
### Splash 화면
<p align="center">
    <img src="https://user-images.githubusercontent.com/96619472/208282881-c7028971-0c99-4fb6-a0f9-4f59831017e3.png" width="300"/>
</p>

ObjectAnimator를 이용하여 왼쪽에서 오른쪽으로 이동하는 스플래쉬화면 구현

### 로그인 화면
<p align="center">
    <img src="https://user-images.githubusercontent.com/96619472/208282884-fb04dfc0-41ad-412c-9125-3b94dc313d6c.png" width="40%" height="30%">
    <img src="https://user-images.githubusercontent.com/96619472/208282885-f99e7512-d2be-4005-8374-bf8d1897270f.png" width="40%" height="30%">
</p>

영상을 찍는 도중 카카오톡은 설치되어있으나 로그인하지 않은 상태에서 loginWithKakaoTalk()를 호출하면 AuthError가 발생하며, 
errorDescription은 KakaoTalk is installed but not connected to Kakao account. 이라고 출력하는 오류 발생

카카오 계정으로 로그인할 수 있는 방안으로 바꿈

### 홈화면
<p align="center">
    <img src="https://user-images.githubusercontent.com/96619472/208282882-02af7fc8-a1f6-4dab-be1d-8edc3f012632.png" width="40%" height="30%">
    <img src="https://user-images.githubusercontent.com/96619472/208282883-e3297599-bcba-4425-a814-79f6c99fa30a.png" width="40%" height="30%">
</p>

영화 이름, 관객 수, 영화 이미지, 투표 퍼센트 이용

(해외 api라 그런지 데이터 하나하나 이해하는데 오래걸렸고 데이터들이 어떤것을 의미하는지 힘들었다.)

***
### 화면을 만들면서 배운것
* ViewPager2 중접 문제 발생 -> https://yunjaem06.tistory.com/121 해결완료
* Kakao login Api 
* retrofit2을 사용하여 api 적용

#### 공부해야할 것들
* 처음 api를 적용해봤는데 국내 영화 오픈 api는 찾기 힘들어서 해외 api를 사용하였다.
* 네이버 로그인 api 구현해보기
* 카카오, 네이버 지도api 구현해보기
* `<uses-permission android:name="android.permission.INTERNET" />`(까먹지 말고 작성하자 ㅠ)