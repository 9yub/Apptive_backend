# 📘 Git 작업 흐름 정리 (Apptive_backend)

개발 시작을 위한 Git 브랜치 및 원격 설정 과정입니다.  
Jira 이슈 키 기반으로 브랜치를 관리하며, 단순하고 실용적인 네이밍을 사용합니다.

---

## 1. 🧱 Git 저장소 초기화

```bash
git init
```
- 현재 폴더를 Git 저장소로 초기화
- `.git` 폴더 생성됨

## 2. 🔗 GitHub 원격 저장소 연결

```bash
git remote add origin https://github.com/9yub/Apptive_backend.git
git remote -v
```
- 원격 저장소 등록 (`origin`이라는 이름으로 설정)
- `git remote -v`로 연결 여부 확인 가능

## 3. 📥 원격 브랜치 정보 가져오기

```bash
git fetch origin
```
- GitHub 저장소의 `main` 브랜치 정보를 로컬에 가져옴
- 아직 `checkout`은 하지 않은 상태

## 4. 🌱 기능 브랜치 생성 (Jira 연동 네이밍)

```bash
git checkout -b KAN-1-kakao-login
```
- Jira 이슈 키(`예: KAN-1`)을 기반으로 브랜치 생성
- 간단하고 실용적인 브랜치 네이밍

## 5. 🚀 GitHub 원격 브랜치로 푸시 & 연동

```bash
git push -u origin KAN-1-kakao-login
```
- GitHub에 새로운 브랜치를 업로드
- `-u` 옵션으로 원격 브랜치와 연결 (tracking 설정)
- 이후 `git push`, `git pull`에서 브랜치 명 생략 가능

## 💡 앞으로 개발 하면서

`git add`, `git commit` : 변경된 파일을 커밋하여 저장
`Pull Request` :	GitHub에서 PR을 생성하여 코드 리뷰 및 병합 요청
