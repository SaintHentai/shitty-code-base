# Активные трейдеры:

Вам нужно определить, какие пользователи совершили более 5% от общего числа покупок. Имена активных пользователей должны быть возвращены в виде списка строк в отсортированном порядке.

Eg Input : customers -> ['A', 'B', 'O', 'O', 'A' ]

Eg Output : answer  -> ['A', 'B', 'O']

Решение:

Мы начинаем с исходного списка клиентов ["A", "O", "B", "O", "A"] и определяем процентное соотношение каждого клиента относительно общего числа сделок:

- A: 2 сделки из 5 → (2/5) * 100 = 40%
- B: 1 сделка из 5 → (1/5) * 100 = 20%
- O: 2 сделки из 5 → (2/5) * 100 = 40%

Затем мы сортируем имена клиентов по алфавиту и добавляем их в новый список:

1. A
2. B
3. O

Таким образом, новый список клиентов будет ["A", "B", "O"].