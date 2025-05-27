#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

// 노드 정의
typedef struct node {
    char data;
    struct node* next;
} node;

// 스택 구조체
typedef struct {
    node* top;
    int size;
} STACK;

// 스택 함수 정의
void init_STACK(STACK* s) {
    s->top = NULL;
    s->size = 0;
}

int is_stack_empty(STACK* s) {
    return s->size == 0;
}

void push_stack(STACK* s, char data) {
    node* newnode = malloc(sizeof(node));
    newnode->data = data;
    newnode->next = s->top;
    s->top = newnode;
    s->size++;
}

char pop_stack(STACK* s) {
    if (is_stack_empty(s)) return '\0';
    node* temp = s->top;
    char data = temp->data;
    s->top = temp->next;
    s->size--;
    free(temp);
    return data;
}

void flush_stack(STACK* s) {
    while (!is_stack_empty(s)) {
        printf("%c", pop_stack(s));
    }
}

int main() {
    char str[100001];
    fgets(str, sizeof(str), stdin);

    STACK s;
    init_STACK(&s);

    int in_tag = 0;

    for (int i = 0; str[i] != '\0'; i++) {
        char c = str[i];

        if (c == '<') {
            // 단어 뒤집기 마무리하고 태그 출력 시작
            flush_stack(&s);
            in_tag = 1;
            printf("%c", c);
        }
        else if (c == '>') {
            in_tag = 0;
            printf("%c", c);
        }
        else if (in_tag) {
            // 태그 안: 그대로 출력
            printf("%c", c);
        }
        else {
            // 태그 밖
            if (c == ' ' || c == '\n') {
                flush_stack(&s);
                printf("%c", c);
            } else {
                push_stack(&s, c);
            }
        }
    }

    // 마지막 남은 단어 뒤집기
    flush_stack(&s);

    return 0;
}
