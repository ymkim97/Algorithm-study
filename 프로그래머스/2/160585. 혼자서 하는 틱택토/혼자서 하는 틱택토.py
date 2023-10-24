def solution(board):
    answer = 1
    O = 0
    X = 0
    
    for row in board:
        O += row.count("O")
        X += row.count("X")
    
    if X > O:
        return 0
    
    if X == O:
        if O >= 3: # O:3, X:3 이상 일때 O가 이기면 안된다.
            for row in board: # 가로줄
                if row.count("O") == 3:
                    return 0
                
            for i in range(3): # 세로줄
                if board[0][i] == board[1][i] == board[2][i] == "O":
                    return 0
                
            if board[0][0] == board[1][1] == board[2][2] == "O": # 사선1
                return 0
        
            if board[0][2] == board[1][1] == board[2][0] == "O": # 사선2
                return 0
    
    if X < O:
        if O - X != 1:
            return 0

        
        # X가 이긴 경우
        for row in board: # 가로줄
            if row.count("X") == 3:
                return 0

        for i in range(3): # 세로줄
            if board[0][i] == board[1][i] == board[2][i] == "X":
                return 0

        if board[0][0] == board[1][1] == board[2][2] == "X": # 사선1
            return 0

        if board[0][2] == board[1][1] == board[2][0] == "X": # 사선2
            return 0

    return answer