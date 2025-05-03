# 📘 Git 작업 흐름 정리 (Apptive_backend)

> 개발 시작을 위한 Git 브랜치 및 원격 설정 과정입니다.  
> Jira 이슈 키 기반으로 브랜치를 관리하며, 단순하고 실용적인 네이밍을 사용합니다.

---

### 1. 🧱 Git 저장소 초기화

```bash
git init
```
- 현재 폴더를 Git 저장소로 초기화
- `.git` 폴더 생성됨


### 2. 🔗 GitHub 원격 저장소 연결

```bash
git remote add origin https://github.com/9yub/Apptive_backend.git
git remote -v
```
- 원격 저장소 등록 (`origin`이라는 이름으로 설정)
- `git remote -v`로 연결 여부 확인 가능


### 3. 📥 원격 브랜치 정보 가져오기

```bash
git fetch origin
```
- GitHub 저장소의 `main` 브랜치 정보를 로컬에 가져옴
- 아직 `checkout`은 하지 않은 상태


### 4. 🌱 기능 브랜치 생성 (Jira 연동 네이밍)

```bash
git checkout -b KAN-1-kakao-login
```
- Jira 이슈 키(`예: KAN-1`)을 기반으로 브랜치 생성
- 간단하고 실용적인 브랜치 네이밍
- 브랜치 네임은 항상 영문으로만 구성


### 5. 🚀 GitHub 원격 브랜치로 푸시 & 연동

```bash
git push -u origin KAN-1-kakao-login
```
- GitHub에 새로운 브랜치를 업로드
- `-u` 옵션으로 원격 브랜치와 연결 (tracking 설정)
- 이후 `git push`, `git pull`에서 브랜치 명 생략 가능


### 💡 앞으로 개발 하면서

- `git add`, `git commit` : 변경된 파일을 커밋하여 저장
- `Pull Request` :	GitHub에서 PR을 생성하여 코드 리뷰 및 병합 요청


# ✍️ 커밋 메시지 작성 규칙

> 커밋 메시지를 일관되게 관리하여 프로젝트의 변경 이력을 명확하게 추적할 수 있도록 합니다.

---

### ✅ 커밋 메시지 구조

```text
스프린트번호 <커밋유형: 커밋 내용 설명>

예: KAN-3 <Feat: Kakao login 구현>
```
- 스프린트 번호는 Jira 이슈 키 등으로 작성 (예: KAN-3)
- 커밋 유형은 영어 대문자로 작성 (예: Feat:)
- 커밋 내용은 간결하고 명확하게 작성

### 🔖 커밋 유형 정의

| 커밋 유형              | 설명                               |
| ------------------ | -------------------------------- |
| `Feat`             | 새로운 기능 추가                        |
| `Fix`              | 버그 수정                            |
| `Docs`             | 문서 수정                            |
| `Style`            | 코드 포맷팅 (세미콜론, 들여쓰기 등), 로직 변화 없음  |
| `Refactor`         | 코드 리팩토링, 기능 변화 없음                |
| `Test`             | 테스트 코드 추가 및 리팩토링                 |
| `Chore`            | 기타 수정 (ex: 패키지 설정, `.gitignore`) |
| `Design`           | CSS 등 UI 스타일 변경                  |
| `Comment`          | 주석 추가 또는 변경                      |
| `Rename`           | 파일/폴더 이름 변경만 수행한 경우              |
| `Remove`           | 파일 삭제만 수행한 경우                    |
| `!BREAKING CHANGE` | 주요 API 변경 등 큰 변화가 있을 때           |
| `!HOTFIX`          | 긴급한 치명적 버그 수정                    |

👉🏻 커밋 팁: 한 커밋 = 하나의 작업

- 커밋 하나에 너무 많은 내용을 담지 말 것
- 변경 내용을 추적하기 쉽게 유지
- 관련된 변경만 하나의 커밋에 포함


💡 예시

```text
KAN-10 Fix: 로그인 시 토큰 만료 예외 처리 추가
KAN-11 Refactor: 소셜 로그인 응답 모델 분리
KAN-12 Docs: README에 Git 브랜치 전략 추가
```
