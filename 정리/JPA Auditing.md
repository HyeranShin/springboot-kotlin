**1. BaseTimeEntity 클래스 생성**

kotlin 코드

```kotlin
@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseTimeEntity(@CreatedDate var createdDate: LocalDateTime? = null,
                              @LastModifiedDate var modifiedDate: LocalDateTime? = null)
```

java 코드

```java
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {
    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
```

모든 Entity들의 상위 클래스가 되어 Entity들의 createdDate, modifiedDate를 자동으로 관리

-   **@MappedSuperclass** : JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우 필드들(createdDate, modifiedDate)도 컬럼으로 인식하도록 한다.
-   **@EntityListeners(AuditingEntityListener.class)** : BaseTimeEntity 클래스에 Auditing 기능을 포함시킨다.
-   **@CreatedDate** : Entity가 생성되어 저장될 때 시간이 자동 저장된다.
-   **@LastModifiedDate** : 조회한 Entity의 값을 변경할 때 시간이 자동 저장된다.

**2. Domain 클래스가 BaseTimeEntity를 상속받도록 변경**

**3. Application 클래스에 @EnableJpaAuditing(JPA Auditing 활성화 어노테이션) 추가**