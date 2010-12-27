#!/usr/bin/env python
import abc
board = None

class Board:
	#outer list is y, inner lists are x
	_grid = None
	
	def __init__(self):
		self._grid = list(xrange(44))
		for i in self._grid:
			self._grid[i] = list(xrange(44))
	
	def isHexCoordinate(self,x,y):
		if y % 2 == 0:
			if x % 2 == 1:
				return True
			else:
				return False
		elif x % 2 == 0:
			return True
		else:
			return False
	
	def getAdjacentPieces(self,x,y):
		l = []
		if self.isHexCoordinate(x,y):
			if y - 2 >= 0:
				l.append((x,y-2))
			if x + 1 < len(self._grid) and y - 1 >= 0:
				l.append((x+1,y-1))
			if x + 1 < len(self._grid) and y + 1 < len(self._grid):
				l.append((x+1,y+1))
			if y + 2 < len(self._grid):
				l.append((x,y+2))
			if x - 1 >= 0 and y + 1 < len(self._grid):
				l.append((x-1,y+1))
			if x - 1 >= 0 and y - 1 >= 0:
				l.append((x-1,y-1))
		return l

class Piece:
	__metaclass__ = abc.ABCMeta
	_player = None
	_top = None
	
	def __init__(self, p, board):
		self._player = p
	
#	Check if moving it will make some pieces stranded from the rest of the hive.
	def isOnlyLink():
		pass
	
#	Check if it has room to move.
	def isStuck():
		pass
	
#	Check if there is a beatle on top of this piece.
	def isHeavy():
		pass
	
#	Check if it's allowed to go there, assuming all other conditions are cleared.
	@abc.abstractmethod
	def isValidDestination():
		pass
	
#	Check all preconditions for movement in their correct order.
	def isLegalMove(self,sx, sy, dx, dy):
		pass
	def isValidInsert(self,dx, dy):
		pieces = board.getAdjacentPieces(dx, dy)
		hasSamePlayer = False
		for piece in pieces:
			if piece._player == self._player:
				hasSamePlayer = True
			else:
				return False
		return hasSamePlayer

class Bee(Piece):
	pass
class Ant(Piece):
	pass
class Beetle(Piece):
	pass
class Grasshopper(Piece):
	pass
class Spider(Piece):
	pass

