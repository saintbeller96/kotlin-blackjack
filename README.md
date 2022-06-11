# kotlin-blackjack

## 기능 요구사항

블랙잭 게임을 변형한 프로그램을 구현한다. 블랙잭 게임은 딜러와 플레이어 중 카드의 합이 21 또는 21에 가장 가까운 숫자를 가지는 쪽이 이기는 게임이다.

카드의 숫자 계산은 카드 숫자를 기본으로 하며, 예외로 Ace는 1 또는 11로 계산할 수 있으며, King, Queen, Jack은 각각 10으로 계산한다. 게임을 시작하면 플레이어는 두 장의 카드를 지급 받으며,
두 장의 카드 숫자를 합쳐 21을 초과하지 않으면서 21에 가깝게 만들면 이긴다. 21을 넘지 않을 경우 원한다면 얼마든지 카드를 계속 뽑을 수 있다.

딜러는 처음에 받은 2장의 합계가 16이하이면 반드시 1장의 카드를 추가로 받아야 하고, 17점 이상이면 추가로 받을 수 없다.
딜러가 21을 초과하면 그 시점까지 남아 있던 플레이어들은 가지고 있는 패에 상관 없이 승리한다.
게임을 완료한 후 각 플레이어별로 승패를 출력한다.

## 실행 결과

```
게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)
pobi,jason

pobi, jason에게 2장의 나누었습니다.
pobi카드: 2하트, 8스페이드
jason카드: 7클로버, K스페이드

pobi는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
y
pobi카드: 2하트, 8스페이드, A클로버
pobi는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n
jason은 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n
jason카드: 7클로버, K스페이드

pobi카드: 2하트, 8스페이드, A클로버 - 결과: 21
jason카드: 7클로버, K스페이드 - 결과: 17
```

## 도메인 요구 사항

### 카드(Card)
- 카드는 `끗수(Denomination)`와 `무늬(Suit)`를 가진다.

#### 무늬(Suit)
- 카드 무늬는 Spade, Heart, Clover, Diamond 4가지로 구성된다

#### 숫자(Denomination)
- 끗수의 종류는 Ace와 2~10, 그리고 Jack, Queen, King 으로 총 13가지다.
- 끗수 별 점수는 카드 숫자를 기본으로 하며, 예외로 Ace는 1 또는 11의 점수를 가질 수 있으며, King, Queen, Jack은 각각 10의 점수를 가진다

### 카드 덱(Deck)
- [x] 카드 한 장을 뽑을 수 있다.
- [x] 만약 덱에 카드가 남아있지 않은 경우 카드를 뽑을 수 없다.

### 카드 패(Hand)
- [x] 카드 패에 새로운 카드를 추가할 수 있다.
- [x] 카드 패에 포함된 카드의 점수를 계산할 수 있다.
- [x] 카드 패에 끗수가 ACE인 카드가 포함된 경우, 가장 유리한 점수를 계산한다.
  - `ACE 카드를 제외한 다른 모든 카드의 점수`와 `ACE 카드로 만들 수 있는 모든 점수의 조합 중 하나`를 더한 값 중, 21 보다 작거나 같은 값이 있다면 그 값 중 가장 큰 값을 선택한다.
  - 모든 값이 21이 넘는 경우 그 중에서 가장 작은 값을 선택한다.

### 참가자(Participant)
- 이름을 가질 수 있다.
- 카드 패를 가질 수 있다.
- 상태를 가질 수 있다.
- 카드를 한 장 받을 수 있다.

### 상태(State)
- Hittable: hit을 할 수 있는 상태
- Stay: 카드를 더 이상 받지 않는 상태
- BlackJack: 카드 패의 점수가 21인 상태
- Bust: 카드 패의 점수가 21을 초과한 상태

### 플레이어(Player)
- 참가자 속성을 가진다.
- hit을 선택할 수 있다.
- [ ] 카드를 받을 때마다 상태를 변경한다.
- [x] 최초 상태는 `Hittable` 상태다.
- [ ] 카드 패의 점수가 21이면 `BlackJack` 상태다.
- [ ] 카드 패의 점수가 21 초과면 `Bust` 상태다.
- [ ] hit을 선택하지 않으면 `Stay` 상태다.
- [ ] `Hittable` 상태에서만 카드를 받을 수 있다.
